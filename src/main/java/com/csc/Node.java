package com.csc;

// Don't change this file!

public class Node {
  ChainLink chain;
  Node next;
  Node prev;

  public Node(ChainLink chain, Node root) {
    if (root.getNext() == null) {
      this.chain = chain;
      this.prev = root;
      root.setNext(this);
    } else {
      throw new RuntimeException("Node already exists at this position");
    }

  }

  public void prepend(Node n){
    if(this.prev == null){
      this.prev = n;
      n.next = this;
    } else {
      throw new RuntimeException("Node already exists at this position");
    }
  }

  public Node() {
    chain = null;
    next = null;
  }

  public ChainLink getChain() {
    return chain;
  }
  public void setChain(ChainLink chain) {
    this.chain = chain;
  }
  public Node getNext() {
    return next;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  public int size(){
    int count = 0;
    Node n = this;
    while(n.getNext() != null){
      n = n.getNext();
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Node n = new Node();
    ChainLink link1 = new ChainLink("red");
    ChainLink link2 = new ChainLink("blue");
    ChainLink link3 = new ChainLink("green");
    ChainLink link4 = new ChainLink("yellow");
    n.setChain(link1);
    Node n2 = new Node(link2,n);
    try {
      Node n3 = new Node(link3,n);

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(n.getChain().color);
    System.out.println(n.getNext().getChain().color);
    Node n3 = new Node(link3,n2);
    Node retrievedNode = n2.getNext();
    ChainLink retrievedLink = retrievedNode.getChain();
    System.out.println(retrievedLink.color);
    System.out.println(n.size()); //should be 2
    Node n4 = new Node();
    n4.setChain(link4);
    n.prepend(n4);
    System.out.println(n4.getChain().color);
    System.out.println(n4.getNext().getChain().color);

  }


}

