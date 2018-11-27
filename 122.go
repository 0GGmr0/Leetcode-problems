package main

import (
	"fmt"
)

func maxProfit(prices []int) int {
	length := len(prices)
	ans := 0
	for i := 1; i < length; i++ {
		if prices[i] > prices[i - 1] {
			ans += prices[i] - prices[i - 1]
		}
	}
	return ans
}

func main() {

	var prices = []int{7, 1, 5, 3, 6, 4}
	fmt.Print(maxProfit(prices))
}
