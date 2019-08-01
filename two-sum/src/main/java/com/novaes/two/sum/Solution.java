/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.two.sum;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class Solution {
    
    

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
        }
        numbers = Arrays.stream(numbers).sorted().collect(Collectors.toList()).toArray(new Number[]{});
        int i = 0;
        int j = numbers.length - 1;

        while (numbers[i].num + numbers[j].num != target) {
            if (numbers[i].num + numbers[j].num > target) {
                j--;
            } else {
                i++;
            }
        }
        if(numbers[i].position > numbers[j].position) {
            
        }
        result[0] = Math.min(numbers[i].position, numbers[j].position);
        result[1] = Math.max(numbers[i].position, numbers[j].position);
        return result;
    }

    class Number implements Comparable<Number> {

        int num;
        int position;

        public Number() {
        }

        public Number(int num, int position) {
            this.num = num;
            this.position = position;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.num, o.num);
        }

    }
    
    public static void main(String[] args) {
        int[] array = new int[]{1,0,-1};
        int t = 1;
        System.out.println(Arrays.toString(new Solution().twoSum(array, t)));
    }

}
