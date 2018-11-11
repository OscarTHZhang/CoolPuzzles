package com.example.shihaochen.coolpuzzles;

import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

/**
 * This is a class that will take in a ViewGroup object, which inherits TableLayout
 */
public class LayoutArray {

  private TableLayout tableLayout; // the original table layout
  private View[][] images; // the 2-d array that stores the ImageView objects

  public LayoutArray(TableLayout tableLayout) {
    this.tableLayout = tableLayout;
    // this.tableLayout.getChildCount() should be a perfect square number
    int dimension = 3;
    this.images = new View[dimension][dimension];

    // puting the ImageView into the 2-d array
    this.images[0][0] = (View) this.tableLayout.getChildAt(0);
    this.images[0][1] = (View) this.tableLayout.getChildAt(1);
    this.images[0][2] = (View) this.tableLayout.getChildAt(2);
    this.images[1][0] = (View) this.tableLayout.getChildAt(3);
    this.images[1][1] = (View) this.tableLayout.getChildAt(4);
    this.images[1][2] = (View) this.tableLayout.getChildAt(5);
    this.images[2][0] = (View) this.tableLayout.getChildAt(6);
    this.images[2][1] = (View) this.tableLayout.getChildAt(7);
    this.images[2][2] = (View) this.tableLayout.getChildAt(8);


  }

  // getter method of the instance field
  public TableLayout getTableLayout() { return this.tableLayout; }
  public View[][] getImages() {
    return this.images;
  }

  /**
   * Check the correctness of user result
   * @param key is the 2-d array that is returned in the SplitImage class, which is the key of this
   *        puzzle
   * @return true if the this.images is matched with the key array, false otherwise
   */
  public boolean isMatch(View[][] key) {
    try {
      for (int i=0; i<this.images.length; i++) {
        for (int j=0; j<this.images.length; j++) {
          if (this.images[i][j].getId() != key[i][j].getId()) return false;
        }
      }
      return true;
    } catch (NullPointerException e) {
      // if the array is not filled, then there must be NullPointerException if traverse the array
      // to compare ImageView
      return false;
    }
  }

}