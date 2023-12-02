int minimumSubarray(int n, int x, int y, vector<int> &a)
{
    // Write your code here.
    int ans = n + 1;

    for (int start = 0, end = 0, mini = 0, maxi = 0; end < n; ++end)
    {
        if (a[end] < 0)
            mini += a[end];
        else
            maxi += a[end];

        while (mini <= x && maxi >= y)
        {
            ans = std::min(ans, end - start + 1);

            if (a[start] < 0)
                mini -= a[start];
            else
                maxi -= a[start];

            ++start;
        }
    }

    return (ans == n + 1) ? -1 : ans;
}