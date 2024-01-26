package com.soulmeadows;
//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/
import com.soulmeadows.Reader4;
public class BufferedReadFile extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] tempRead = new char[4];
    private int tempPtr = 0;
    private int readCount = 0;
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n) {
            if(tempPtr == 0){
                readCount = read4(tempRead);
            }
            if(readCount == 0){
                break;
            }
            while(ptr < n && tempPtr < readCount) {
                buf[ptr++] = tempRead[tempPtr++];
            }
            if(tempPtr >= readCount) {
                tempPtr = 0;
            }
        }
        return ptr;
    }
}