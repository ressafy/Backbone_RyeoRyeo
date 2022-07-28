package com.ssafy.live3.inter.replace.client;

import com.ssafy.live3.inter.replace.Calculator;

class CalculatorStub implements Calculator {
    public int add(int a, int b) {
      System.out.printf("파라미터 확인: %d, %d%n", a, b);
      return 0;  // 사실 정확한건 필요한건 아니고 일단 일하기 위한 정도의 구현만.
    }
  }

