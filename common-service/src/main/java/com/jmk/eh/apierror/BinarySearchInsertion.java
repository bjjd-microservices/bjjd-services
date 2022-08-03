package com.jmk.eh.apierror;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchInsertion {

    static Node root; 
    static class Node {
    	int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    }  
    /* Inorder traversal of a binary tree (Left, Root, Right)*/
    static void inorder(Node temp) 
    { 
        if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.key+" "); 
        inorder(temp.right); 
    } 
       
    /*function to insert element in binary tree */
    static void insert(Node temp, int key) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
       
        // Do level order traversal until we find an empty place. For this Level order traversal we used Queue. 
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new Node(key); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new Node(key); 
                break; 
            } else
                q.add(temp.right); 
        } 
    } 
       
    // Driver code 
    public static void main(String args[]) 
    { 
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(1);
        root.left.right.left = new Node(16);
        root.left.right.right = new Node(20);
        
        
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
       
        System.out.print( "Inorder traversal before insertion:"); 
        inorder(root); 
       
        int key = 12; 
        insert(root, key); 
       
        System.out.print("\nInorder traversal after insertion:"); 
        inorder(root); 
    } 

}
