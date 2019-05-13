/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Insets;
/*    */ import java.awt.geom.AffineTransform;
/*    */ import javax.swing.Timer;
/*    */ 
/*    */ public class TitlesPanel extends javax.swing.JPanel implements java.awt.event.ActionListener
/*    */ {
/*    */   private Graphics2D g2d;
/*    */   private Timer animation;
/*    */   private boolean is_done;
/* 12 */   private int start_angle = 0;
/*    */   private int shape;
/*    */   
/*    */   public TitlesPanel(int _shape) {
/* 16 */     this.is_done = true;
/* 17 */     this.shape = _shape;
/* 18 */     this.animation = new Timer(50, this);
/* 19 */     this.animation.setInitialDelay(50);
/* 20 */     this.animation.start();
/*    */   }




/**
* Method Detail: 
* void actionPerformed(ActionEvent e)
* Invoked when an action occurs.
*
*
*/ 


/*    */ 
/*    */   public void actionPerformed(java.awt.event.ActionEvent arg0)
/*    */   {
/* 26 */     if (this.is_done) {
/* 27 */       repaint();
/*    */     }
/*    */   }


/**
* paintComponent:
* protected void paintComponent(Graphics g)
* Calls the UI delegate's paint method, if the UI delegate is non-null. We pass the delegate a copy of the Graphics object to protect the rest of the paint code from irrevocable changes (for example, Graphics.translate).
*
*
*/



  
/*    */   private void doDrawing(Graphics g) {
/* 32 */     this.is_done = false;
/* 33 */     this.g2d = ((Graphics2D)g);
/* 34 */     this.g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, 
/* 35 */       java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
/*    */     
/* 37 */     java.awt.Dimension size = getSize();
/* 38 */     Insets insets = getInsets();
/*    */     
/* 40 */     int w = size.width - insets.left - insets.right;
/* 41 */     int h = size.height - insets.top - insets.bottom;
/*    */     
/* 43 */     ShapeFactory shape = new ShapeFactory(this.shape);
/* 44 */     this.g2d.setStroke(shape.stroke);
/* 45 */     this.g2d.setPaint(shape.paint);
/* 46 */     double angle = this.start_angle++;
/* 47 */     if (this.start_angle > 360) this.start_angle = 0;
/* 48 */     double dr = 90.0D / (w / (shape.width * 1.5D));
/* 49 */     for (int j = shape.height; j < h; j = (int)(j + shape.height * 1.5D))
/* 50 */       for (int i = shape.width; i < w; i = (int)(i + shape.width * 1.5D)) {
/* 51 */         angle = angle > 360.0D ? 0.0D : angle + dr;
/* 52 */         AffineTransform transform = new AffineTransform();
/* 53 */         transform.translate(i, j);
/* 54 */         transform.rotate(Math.toRadians(angle));
/* 55 */         this.g2d.draw(transform.createTransformedShape(shape.shape));
/*    */       }
/* 57 */     this.is_done = true;
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g)
/*    */   {
/* 62 */     super.paintComponent(g);
/* 63 */     doDrawing(g);
/*    */   }
/*    */ }


/* Location:              C:\Users\drago\Downloads\lab3.jar!\TitlesPanel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */