package assignment5;

import java.io.*;
import java.util.*;

/**
 *
 * @author: Donnie Sandlin 
 * Assignment 4 
 * 11/1/2015
 */
public class Assignment4Client {

    public static void main(String[] args) {

        Assignment4Client a = new Assignment4Client();

        Assignment4 test = new Assignment4();

        test.readFile();
        test.readSpelling();
        System.out.println(test);

    }

}
