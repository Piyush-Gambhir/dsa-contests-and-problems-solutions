vector<long long> summationOfAnd(int n, vector<int> &A, int m, vector<vector<int>> &B)
{
    vector<vector<pair<int, int>>> pref(20, vector<pair<int, int>>(n));
    vector<vector<int>> next(20, vector<int>(n, 0));
    for (int j = 0; j < 20; j++)
    {
        int curr = 0, sum = 0;
        for (int i = 0; i < n; i++)
        {
            if ((A[i] & (1 << j)) > 0)
            {
                curr++;
                sum += curr;
                pref[j][i] = {curr, sum};
            }
            else
            {
                if (curr > 0)
                {
                    next[j][i - 1] = i - 1;
                }
                curr = 0;
                pref[j][i] = {curr, sum};
            }
        }
        next[j][n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--)
        {
            if (next[j][i] == 0)
            {
                next[j][i] = next[j][i + 1];
            }
        }
    }
    vector<long long> ans;
    for (int i = 0; i < B.size(); i++)
    {
        int u = B[i][0] - 1;
        int v = B[i][1] - 1;
        long long res = 0;
        for (int j = 0; j < 20; j++)
        {
            long long temp;
            if (u == 0)
            {
                temp = pref[j][v].second;
            }
            else if (pref[j][u].first == 0)
            {
                temp = pref[j][v].second - pref[j][u].second;
            }
            else
            {
                int right = min(v, next[j][u]);
                temp = pref[j][v].second - pref[j][right].second;
                if (pref[j][right].first > 0)
                {
                    temp += (right - u + 1) * (right - u + 2) / 2;
                }
            }
            res += (temp * (1 << j));
        }
        ans.push_back(res);
    }
    return ans;
}
