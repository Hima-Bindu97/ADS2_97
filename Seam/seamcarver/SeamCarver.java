/*
    Author:Bindu
*/
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;
public class SeamCarver {
	private double[][] energy;
	private int[][] edgeTo;
	private double[][] distTo;
	private static final int vertical=1;
    private static final int horizantal=0;
    private Picture picture;
	private int width,height;
	private Color pixel[][];
	public SeamCarver(Picture picture) {
		if(picture==null){
            throw new java.lang.IllegalArgumentException();
        }
		width=picture.width();
		height=picture.height();	
		pixel=new Color[width][height];		
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				pixel[i][j]=picture.get(i,j);
			}
		}
		init_Energy();
	}
	private void init() {
		edgeTo=new int[width][height];
		distTo=new double[width][height];
		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {
				if(j==0) 
					distTo[i][j]=energy[i][j];
				else 
					distTo[i][j]=Double.POSITIVE_INFINITY;
			}
		}
    }
    private void init_Energy() {
		energy=new double[width][height];
		for(int i=0;i<width;i++) {
			for(int j= 0;j<height;j++) {
				energy[i][j]=this.energy(i,j);
			}
		}
	}
	private void reverse_init() {
		edgeTo=new int[width][height];
		distTo=new double[width][height];
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				if(i==0) 
					distTo[i][j]=energy[i][j];
				else
					distTo[i][j]=Double.POSITIVE_INFINITY;				
			}
		}
	}
	public Picture picture() {
		Picture picture = new Picture(width, height);
		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {
				picture.set(i,j,this.pixel[i][j]);
			}
		}
		return picture;
    }
    public int height() {
		return height;
    }
	public int width() {
		return width;
	}
    public double energy(int x, int y) {
		if(x>=width || y>=height)
			throw new java.lang.IllegalArgumentException();
		if(x==0 || y==0 || x==width-1 ||y==height-1)
			return 1000;
		Color left=pixel[x-1][y];
		int left_r=left.getRed();
		int left_g=left.getGreen();
		int left_b=left.getBlue();
		Color right=pixel[x+1][y];	
		int right_r=right.getRed();
		int right_g=right.getGreen();
		int right_b=right.getBlue();
		Color up=pixel[x][y-1];
		int up_r=up.getRed();
		int up_g=up.getGreen();
		int up_b=up.getBlue();
		Color down = pixel[x][y+1];	
		int down_r=down.getRed();
		int down_g=down.getGreen();
		int down_b=down.getBlue();
		double deltaX=Math.pow((left_r-right_r),2)+Math.pow((left_g-right_g),2)+Math.pow((left_b-right_b),2);
		double deltaY=Math.pow((up_r-down_r),2)+Math.pow((up_g-down_g),2)+Math.pow((up_b-down_b),2);
		return Math.sqrt(deltaX+deltaY);
    }
    public int[] findVerticalSeam() {
		init();
		for(int j=0;j<this.height()-1;j++) {
			for(int i=0;i<this.width();i++) {
				relax(i,j,i,j+1,vertical);
				if(i>0)
					relax(i,j,i-1,j+1,vertical);
				if(i<this.width()-1)
					relax(i,j,i+1,j+1,vertical);
			}
		}	
		return findVerticalSP();	
	}
	public int[] findHorizontalSeam() {
		reverse_init();
		for(int i=0;i<this.width()-1;i++) {
			for(int j=0;j<this.height();j++) {
				relax(i,j,i+1,j,horizantal);
				if(j>0)
					relax(i,j,i+1,j-1,horizantal);
				if(j<this.height()-1)
					relax(i,j,i+1,j+1,horizantal);
			}
		}
		return findHorizontalSP();
    }
	private void relax(int fromX,int fromY,int toX,int toY,int dir) {
		if(distTo[toX][toY]>distTo[fromX][fromY]+energy[toX][toY]) {
			distTo[toX][toY]=distTo[fromX][fromY]+energy[toX][toY];
			if(dir==vertical)
				edgeTo[toX][toY]=fromX;
            if(dir==horizantal)
				edgeTo[toX][toY]=fromY;
		}
    }
    private int[] findVerticalSP() {
		double mindis=distTo[0][this.height()-1];
		int index=0;
		for(int i=1;i<this.width();i++) {
			if(distTo[i][this.height()-1]<mindis) {
				mindis=distTo[i][this.height()-1];
				index = i;
			}
		}
		int[] res=new int[this.height()];
		res[this.height()-1]=index;
		for(int i=this.height()-1;i>0;i--) {
			res[i-1]=edgeTo[index][i];
			index=edgeTo[index][i];
		}
		return res;
	}
	private int[] findHorizontalSP() {
		double mindis=distTo[this.width()-1][0];
		int index=0;
		for(int i=1;i<this.height();i++) {
			if(distTo[this.width()-1][i]<mindis) {
				mindis=distTo[this.width()-1][i];
				index=i;
			}
		}
		int[] res=new int[this.width()];
		res[this.width()-1]=index;
		for(int i=this.width()-1;i>0;i--) {
			res[i-1]=edgeTo[i][index];
			index=edgeTo[i][index];
		}
		return res;
    }
    public void removeVerticalSeam(int[] seam) {
		if(seam.length!=this.height()||this.width()<=1){
            throw new java.lang.IllegalArgumentException();
        }
		Color[][] newPixel=new Color[width-1][height];
		for(int j=0;j<this.height();j++) {
			if (seam[j]<0 || seam[j]>=this.width() || (j>0 && Math.abs(seam[j]-seam[j-1])>1)) 
		        throw new java.lang.IllegalArgumentException ();
			for(int i=0;i<this.width();i++) {
				if(i<seam[j])
					newPixel[i][j]=pixel[i][j];
				else if(i>seam[j])
					newPixel[i-1][j]=pixel[i][j];
			}
		}
		this.pixel=newPixel;
		width--;
		init_Energy();
	}
	public void removeHorizontalSeam(int[] seam) {
		if(seam==null || seam.length!=this.width() || this.height()<=1){
			throw new java.lang.IllegalArgumentException();
        }   
		Color[][] newPixel=new Color[width][height-1];
		for(int i=0;i<this.width();i++) {
			if(seam[i]>=this.height() || (i>0 && Math.abs(seam[i]-seam[i-1])>1))
		        throw new IllegalArgumentException();
			for(int j=0;j<this.height();j++) {
				if(j<seam[i])
					newPixel[i][j]=pixel[i][j];
				else if(j>seam[i])
					newPixel[i][j-1]=pixel[i][j];		
			}
		}
		this.pixel=newPixel;
		height--;
		init_Energy();
	}
}