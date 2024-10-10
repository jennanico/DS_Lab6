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
		Paint myPaint = mesh[x][y];
		Paint northPaint = mesh[x][y+1];
		Paint southPaint = mesh[x][y-1];
		Paint eastPaint = mesh[x+1][y];
		Paint westPaint = mesh[x-1][y];
		
		if (mode == BrushMode.paintMode)
		{	
			mesh[x][y] = this.paint;
		}
		
		else if (mode == BrushMode.fillMode)
		{
			if (! myPaint.equals(northPaint) &&
					! myPaint.equals(southPaint) &&
					! myPaint.equals(eastPaint) &&
					! myPaint.equals(westPaint))
			{
				mesh[x][y] = this.paint;
			}
			this.paint(x, y + 1, mesh);
			this.paint(x, y - 1, mesh);
			this.paint(x + 1, y, mesh);
			this.paint(x - 1, y, mesh);
	
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
