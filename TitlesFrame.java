/**
 * @author Galcev
 * @versin 1.0
 * 
 * 
 *This file contains the title of the program. Sets window sizes and launch.
 * This file contains the creation A collection of utility methods for Swing
 */

import javax.swing.JFrame;

/**
 *setTitle
 *public void setTitle(String title)
 *(Sets the title for this frame to the specified string.)
 *@Param: title - the title to be displayed in the frame's border. A null value is treated as an empty string, "".
 *@see: getTitle()
 * 
 *add
 *public Component add(Component comp)
 *
 *setSize
 *public void setSize(int width, int height)
 *@param: width - the new width of this component in pixelsheight - the new height of this component in pixels
 *
 */

public class TitlesFrame extends JFrame
{
  public TitlesFrame()
  {
    initUI();
  }
  private void initUI()
  {
    setTitle("Кривые фигуры");
    setDefaultCloseOperation(3);
    add(new TitlesPanel(78));
    setSize(350, 350);
    setLocationRelativeTo(null);
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        TitlesFrame ps = new TitlesFrame();
	        ps.setVisible(true);
	      }
	    });
	  }
	}


