///////////////////////////////////////////////////////////////////////////////////////////////////
// MadHack Fall 2018
///////////////////////////////////////////////////////////////////////////////////////////////////

import java.awt.image.BufferedImage;

/**
 * This is the node of a graph with 4 connections to other node
 * @author Oscar Zhang
 */
public class Node {

  // instance fields of the graph

  private BufferedImage image; // the image stored on the current node

  // Here are links in four directions
  private Node upper;
  private Node down;
  private Node left;
  private Node right;

  private static int id = 0; // id of the node

  public Node(BufferedImage image) {
    this.image = image;
    this.upper = null;
    this.down = null;
    this.left = null;
    this.right = null;
    id++;
  }
  // setter of node links
  public void setUpper(Node upper) { this.upper = upper; }
  public void setDown(Node down) { this.down = down; }
  public void setLeft(Node left) { this.left = left; }
  public void setRight(Node right) { this.right = right; }

  // getter of node links
  public Node getUpper(){ return this.upper; }
  public Node getDown() { return this.down; }
  public Node getLeft() { return this.left; }
  public Node getRight() { return this.right; }

  // getter of image
  public BufferedImage getImage() { return this.image; }

  // getter of id
  public int getId() { return Node.id; }
}
