package com.example.shihaochen.coolpuzzles;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * This class will split the image into small pieces to form the puzzle
 * Reference: http://www.chansek.com/splittingdividing-image-into-smaller/
 * @author Oscar Zhang
 */
public class ImageSplit {

  private ImageView originalImage; // the original image of the puzzle
  private int dimension; // the dimension of the puzzle (resolution = dimension ^ 2)
  private ArrayList<Bitmap> imagePieces; // image pieces after splits

  /**
   * Constructor of the ImageSplit
   */
  public ImageSplit(ImageView originalImage, int dimension) {
    this.originalImage = originalImage;
    this.dimension = dimension;
    this.imagePieces = new ArrayList<Bitmap>(this.dimension*this.dimension);
    split();
  }

  /**
   * Getter of image pieces
   * @return the arraylist that stores the image pieces
   */
  public ArrayList<Bitmap> getImagePieces() {
    return this.imagePieces;
  }

    public int getDimension() {
        return dimension;
    }

    /**
   * A helper method to split the image
   */
  private void split() {
    int chunks = this.dimension * this.dimension;
    BitmapDrawable drawable = (BitmapDrawable) this.originalImage.getDrawable();
    Bitmap bitmap = drawable.getBitmap();
    Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(),
        true);

    int chunkWidth = bitmap.getWidth() / this.dimension;
    int chunkHeight = bitmap.getHeight() / this.dimension;

    int yCoord = 0;
    for (int x = 0; x < this.dimension; x++) {
      int xCoord = 0;
      for (int y = 0; y < this.dimension; y++) {
        this.imagePieces.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
        xCoord += chunkWidth;
      }
      yCoord += chunkHeight;
    }
  }

}
