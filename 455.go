func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	var(
		len1 = len(g)
		len2 = len(s)
		ans = 0
	)
	for i, j := 0, 0; i < len2 && i < len1; i++ {
			if s[i] >= g[j] {
				ans++
				j++
			}
	}
	return ans
}