import java.util.Stack;
import javafx.scene.paint.Color;


public class PaintBrush
{

	
	Paint paint;
	
	
	enum BrushMode{
		paintMode,
		fillMode,
		pattern1Mode,
		pattern2Mode
	}

	BrushMode mode;
	
	Paint Gold = new PaintColor(Color.GOLD);
	Paint White = new PaintColor(Color.WHITE);
	
	
/**
set the "paint" for the paintbrush
*/	
	public void setPaint(Paint paint)
	{
		this.paint = paint;
	}


/*
   gets the present paint on the paint brush
*/
	public Paint getPaint()
	{
		return this.paint;
	}
	
   
   /*
   makes the paint on the paint brush a brigter shade.
   */
	public void setBrighter()
	{		
		PaintBrighter paintBrighter = new PaintBrighter(this.paint);
		this.paint = paintBrighter;
	}


   /*
      makes the paint on the paintbrush a darker shade
   */
	public void setDarker()
	{
		PaintDarker paintDarker = new PaintDarker(this.paint);
		this.paint = paintDarker;
	}


   /*
      paints the mesh, using the current paint and mode at point x,y
   */
	public void paint(int x, int y, Paint[][] mesh)
	{
		
		if (mode == BrushMode.paintMode)
		{	
			mesh[x][y] = this.paint;
		}
		
		else if (mode == BrushMode.fillMode)
		{
			fillPaint(x, y, mesh, mesh[x][y]);
		}
		
		else if (mode == BrushMode.pattern1Mode)
		{
			patternPaint(x, y, mesh, mesh[x][y]);
		}
	}

	
	private void fillPaint(int x, int y, Paint[][] mesh, Paint ogPaint)
	{
	
		if (mesh[x][y].equals(ogPaint))
		{
			mesh[x][y] = this.paint;
		}
		else {return;}
	
		
		if (x + 1 < mesh[0].length)
		{
			fillPaint(x + 1, y, mesh, ogPaint);
		}
		if (x - 1 > -1)
		{
			fillPaint(x - 1, y, mesh, ogPaint);
		}
		if (y + 1 < mesh.length)
		{
			fillPaint(x, y + 1, mesh, ogPaint);
		}
		if (y - 1 > -1)
		{
			fillPaint(x, y - 1, mesh, ogPaint);
		}
		
	}
	
	
	private void patternPaint(int x, int y, Paint[][] mesh, Paint ogPaint)
	{
	
		if (mesh[x][y].equals(White))
		{
			fillPaint(x, y, mesh, ogPaint);
		}
		
		if (mesh[x][y].equals(ogPaint))
		{
			if (x % 2 == 0)
			{
				mesh[x][y] = White;
			}
			else
			{
				mesh[x][y] = Gold;
			}
		}
		else {return;}
	
		
		if (x + 1 < mesh[0].length)
		{
			patternPaint(x + 1, y, mesh, ogPaint);
		}
		if (x - 1 > -1)
		{
			patternPaint(x - 1, y, mesh, ogPaint);
		}
		if (y + 1 < mesh.length)
		{
			patternPaint(x, y + 1, mesh, ogPaint);
		}
		if (y - 1 > -1)
		{
			patternPaint(x, y - 1, mesh, ogPaint);
		}
	}
	
/*
   set the drawing mode of the paint brush.
*/
	public void pointMode()
	{
		mode= BrushMode.paintMode;
	}

	public void fillMode()
	{
		mode = BrushMode.fillMode;
	}

	public void pattern1Mode()
	{
		mode = BrushMode.pattern1Mode;
	}

	public void pattern2Mode()
	{
		mode = BrushMode.pattern2Mode;
	}

}
