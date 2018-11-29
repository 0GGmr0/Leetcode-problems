package main

import (
	"fmt"
)
//Input:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//Output: 3
func canCompleteCircuit(gas []int, cost []int) int {
	length := len(gas)
	start := length - 1
	end := 0
	ans := gas[start] - cost[start]
	for ; start > end; {
		if ans >= 0 {
			ans += gas[end] - cost[end]
			end++
		} else {
			start--
			ans += gas[start] - cost[start]
		}
	}
	if ans >= 0 {
		return start
	} else {
		return -1
	}
}

func main() {
	var input = []int{1,2,3,4,5}
	var output = []int{3,4,5,1,2}
	fmt.Print(canCompleteCircuit(input, output))
}
