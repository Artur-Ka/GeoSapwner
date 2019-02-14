import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class Frame extends JFrame
{
	private int MIN_X = 0;
	private int MIN_Y = 0;
	private int MAX_X = 1000;
	private int MAX_Y = 1000;
	
	private int _centerX = 300;
	private int _centerY = 300;
	private int _radius = 100;
	private int _startX = 300;
	private int _startY = 400;
	
	private List<Point> _points = new ArrayList<Point>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5503738786153724100L;
	
	public void createGUI()
	{
		setTitle("GeoSpawner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640, 640);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    this.addMouseListener(new MouseListener()
	    {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				for (Point p : _points)
				{
					if (arg0.getX() == p.getX() && arg0.getY() == p.getY())
						System.out.println(p.getX() + " " + p.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
			}

			@Override
			public void mousePressed(MouseEvent arg0)
			{
			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
			}
	    });
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int j = MIN_Y; j < MAX_Y; j++)
		{
			for (int i = MIN_X; i < MAX_X; i++)
			{
				if (((i - _centerX) * (i - _centerX)) + ((j - _centerY) * (j - _centerY)) == (_radius * _radius))
				{
					_points.add(new Point(i, j));
					g.drawLine(i, j, i, j);
				}
			}
		}
	}
	
	private class Point
	{
		private int _x;
		private int _y;
		
		private Point(int x, int y)
		{
			_x = x;
			_y = y;
		}
		
		private int getX()
		{
			return _x;
		}
		
		private int getY()
		{
			return _y;
		}
	}
}