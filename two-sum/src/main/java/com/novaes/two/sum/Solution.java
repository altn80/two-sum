/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.two.sum;

import java.util.Arrays;
import java.util.HashMap;

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
        int i = 0;
        int j = numbers.length - 1;

        while (numbers[i].num + numbers[j].num != target) {
            if (numbers[i].num + numbers[j].num > target) {
                j--;
            } else {
                i++;
            }
        }
        if (numbers[i].position > numbers[j].position) {

        }
        result[0] = Math.min(numbers[i].position, numbers[j].position);
        result[1] = Math.max(numbers[i].position, numbers[j].position);
        return result;
    }
    // Solucao otima
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{0, 0};
        }
        // Map guarda o complemento e o indice do complemento
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // Caso o map contenha o numero corrente, entao o numero corrente eh o complemento
            if (map.containsKey(nums[i])) {
                // Retorna o indice do complemento e o indice do numero corrente.
                return new int[]{map.get(nums[i]), i};
            } else {
                // guarda o complemento
                map.put(target - nums[i], i);
            }
        }

        return new int[]{0, 0};
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
        int[] array = new int[]{1, 0, -1};
        int t = 1;
        System.out.println(Arrays.toString(new Solution().twoSum(array, t)));
    }

}
