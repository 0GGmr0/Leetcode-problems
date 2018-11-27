package main

import (
	"fmt"
)
//[2,3,1,1,4]
func canJump(nums []int) bool {
	length := len(nums)
	pos := length - 1
	for i:= length - 1;i >= 0; i-- {
		if nums[i] >= pos - i {
			pos = i
		}
	}
	return pos == 0
}

func main() {
	var prices = []int{4,2,0,0,1,1,4,4,4,0,4,0}
	fmt.Print(canJump(prices))
}
