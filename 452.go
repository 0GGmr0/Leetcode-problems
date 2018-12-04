package main

import (
	"fmt"
	"sort"
)

type ByEnd [][]int

func (s ByEnd) Len() int {
	return len(s)
}
func (s ByEnd) Swap(i, j int) {
	s[i][0], s[j][0] = s[j][0], s[i][0]
	s[i][1], s[j][1] = s[j][1], s[i][1]
}
func (s ByEnd) Less(i, j int) bool {
	return s[i][1] < s[j][1]
}


func findMinArrowShots(points [][]int) int {
	if(len(points) == 0) { return 0 }
	sort.Sort(ByEnd(points))
	fmt.Println(points)
	arrpos := points[0][1]
	cnt := 1
	for i := 1; i < len(points); i++ {
		if arrpos >= points[i][0] {
			continue
		}
		cnt++
		arrpos = points[i][1]
	}
	return cnt
}


func main() {

}
