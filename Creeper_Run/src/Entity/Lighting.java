package Entity;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.*;
import java.awt.image.*;
import GameState.GameStateManager;

import Main.GamePanel;

public class Lighting {
	private static final Color clrHi = new Color(255, 229, 63);
	private static final Color clrLo = new Color(255, 105, 0);

	private static final Color clrGlowInnerHi = new Color(253, 239, 175, 148);
	private static final Color clrGlowInnerLo = new Color(255, 209, 0);
	private static final Color clrGlowOuterHi = new Color(253, 239, 175, 124);
	private static final Color clrGlowOuterLo = new Color(255, 179, 0);
	private int width = GamePanel.SCREENWIDTH();
	private int height = GamePanel.SCREENHEIGHT();
	
	private Shape createClipShape() {
		
	    float border = 20.0f;

	    float x1 = border;
	    float y1 = border;
	    float x2 = width - border;
	    float y2 = height - border;

	    float adj = 3.0f; // helps round out the sharp corners
	    float arc = 8.0f;
	    float dcx = 0.18f * width;
	    float cx1 = x1-dcx;
	    float cy1 = 0.40f * height;
	    float cx2 = x1+dcx;
	    float cy2 = 0.50f * height;

	    GeneralPath gp = new GeneralPath();
	    gp.moveTo(x1-adj, y1+adj);
	    gp.quadTo(x1, y1, x1+adj, y1);
	    gp.lineTo(x2-arc, y1);
	    gp.quadTo(x2, y1, x2, y1+arc);
	    gp.lineTo(x2, y2-arc);
	    gp.quadTo(x2, y2, x2-arc, y2);
	    gp.lineTo(x1+adj, y2);
	    gp.quadTo(x1, y2, x1, y2-adj);
	    gp.curveTo(cx2, cy2, cx1, cy1, x1-adj, y1+adj);
	    gp.closePath();
	    return gp;
	}

	private BufferedImage createClipImage(Shape s) {
		Graphics g2 = getGraphics();
	    // Create a translucent intermediate image in which we can perform
	    // the soft clipping
	    GraphicsConfiguration gc = g.getDeviceConfiguration();
	    BufferedImage img = gc.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
	    Graphics2D g2 = img.createGraphics();

	    // Clear the image so all pixels have zero alpha
	    g2.setComposite(AlphaComposite.Clear);
	    g2.fillRect(0, 0, width, height);

	    // Render our clip shape into the image.  Note that we enable
	    // antialiasing to achieve the soft clipping effect.  Try
	    // commenting out the line that enables antialiasing, and
	    // you will see that you end up with the usual hard clipping.
	    g2.setComposite(AlphaComposite.Src);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setColor(Color.WHITE);
	    g2.fill(s);
	    g2.dispose();

	    return img;
	}

	private static Color getMixedColor(Color c1, float pct1, Color c2, float pct2) {
	    float[] clr1 = c1.getComponents(null);
	    float[] clr2 = c2.getComponents(null);
	    for (int i = 0; i < clr1.length; i++) {
	        clr1[i] = (clr1[i] * pct1) + (clr2[i] * pct2);
	    }
	    return new Color(clr1[0], clr1[1], clr1[2], clr1[3]);
	}

	// Here's the trick... To render the glow, we start with a thick pen
	// of the "inner" color and stroke the desired shape.  Then we repeat
	// with increasingly thinner pens, moving closer to the "outer" color
	// and increasing the opacity of the color so that it appears to
	// fade towards the interior of the shape.  We rely on the "clip shape"
	// having been rendered into our destination image already so that
	// the SRC_ATOP rule will take care of clipping out the part of the
	// stroke that lies outside our shape.
	private void paintBorderGlow(Graphics2D g2, int glowWidth) {
	    int gw = glowWidth*2;
	    for (int i=gw; i >= 2; i-=2) {
	        float pct = (float)(gw - i) / (gw - 1);

	        Color mixHi = getMixedColor(clrGlowInnerHi, pct,
	                                    clrGlowOuterHi, 1.0f - pct);
	        Color mixLo = getMixedColor(clrGlowInnerLo, pct,
	                                    clrGlowOuterLo, 1.0f - pct);
	        g2.setPaint(new GradientPaint(0.0f, height*0.25f,  mixHi,
	                                      0.0f, height, mixLo));
	        //g2.setColor(Color.WHITE);

	        // See my "Java 2D Trickery: Soft Clipping" entry for more
	        // on why we use SRC_ATOP here
	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, pct));
	        g2.setStroke(new BasicStroke(i));
	        g2.draw(clipShape);
	    }
	}

	Shape clipShape = createClipShape();
	//Shape clipShape = new Ellipse2D.Float(width/4, height/4, width/2, height/2);

	// Clear the background to white
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, width, height);

	// Set the clip shape
	BufferedImage clipImage = createClipImage(clipShape);
	Graphics2D g2 = clipImage.createGraphics();

	// Fill the shape with a gradient
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setComposite(AlphaComposite.SrcAtop);
	g2.setPaint(new GradientPaint(0, 0, clrHi, 0, height, clrLo));
	g2.fill(clipShape);

	// Apply the border glow effect
	paintBorderGlow(g2, 8);

	g2.dispose();

	g.drawImage(clipImage, 0, 0, null);

	private void paintBorderShadow(Graphics2D g2, int shadowWidth) {
		
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	    int sw = shadowWidth*2;
	    for (int i=sw; i >= 2; i-=2) {
	        float pct = (float)(sw - i) / (sw - 1);
	        g2.setColor(getMixedColor(Color.LIGHT_GRAY, pct,
	                                  Color.WHITE, 1.0f-pct));
	        g2.setStroke(new BasicStroke(i));
	        g2.draw(clipShape);
	    }
	}
}
	// Apply the border shadow before we paint the rest of the shape
	paintBorderShadow(g, 6);
}
