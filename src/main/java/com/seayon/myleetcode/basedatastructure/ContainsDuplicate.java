package com.seayon.myleetcode.basedatastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.basedatastructure
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/10/20 2:44 下午
 * @Version V1.0
 * @Description:
 */
@DisplayName("217. 存在重复元素")
class ContainsDuplicate {

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void t(Args args) {
        Solution solution = new Solution();
        assertEquals(args.isExpect(), solution.containsDuplicate(args.getNums()));
    }

    private static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(new Args(false, new int[]{1, 2}),
                    new Args(false, new int[]{}),
                    new Args(true, new int[]{1, 2, 1}),
                    new Args(true, new int[]{1, 2, 1, 1, 1, 1, 1, 1, 1, 1}),
                    new Args(true, new int[]{-1, 0, 0,}),
                    new Args(false, new int[]{1234567, 1})
            ).map(Arguments::of);
        }
    }

    @Data
    @Getter
    @AllArgsConstructor
    private static class Args {
        boolean expect;
        int nums[];
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            return IntStream.of(nums).distinct().count() != nums.length;

         /*   Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }
            return false;*/
        }
    }
}
