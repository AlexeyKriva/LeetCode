fun main() {
    searchRange(intArrayOf(1), 1)
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    var left = 0
    var right = nums.size - 1
    val arr = intArrayOf(-1, -1)
    var isLeftWas = false
    var isRightWas = false

    while (left <= right) {
        if (isLeftWas && isRightWas)
            return arr
        if (!isLeftWas && nums[left] == target) {
            arr[0] = left
            isLeftWas = true
        } else if (!isLeftWas)
            left++
        if (!isRightWas && nums[right] == target) {
            arr[1] = right
            isRightWas = true
        } else if (!isRightWas)
            right--
    }

    return arr
}