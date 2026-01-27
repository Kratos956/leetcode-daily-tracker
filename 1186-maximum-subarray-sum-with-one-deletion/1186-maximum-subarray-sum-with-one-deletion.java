// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        // noDeleteMaxSum: i-th element tak ka max sum, bina kuch delete kiye (Standard Kadane)
        int noDeleteMaxSum = arr[0]; 

        /* oneDeleteMaxSum: i-th element tak ka max sum, jisme exactly EK element delete ho chuka hai
        Why initialised to arr[0] ?
        Kuki agar pehli baar deletion kar rahe hain (i=1 par), 
        toh sirf current element delete hoga, aur bachega sirf pichla element. */
        int oneDeleteMaxSum = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // i-1 tak ka max sum (bina deletion wala)
            int prevNoDeleteMaxSum = noDeleteMaxSum;
            /* Standard Kedane: In dono me se max pick karo
            Option 1: noDeleteMaxSum + arr[i]  -> Purana subarray extend karo
            Option 2: arr[i]  -> Start fresh subarray at i par naya subarray start karo */ 
            noDeleteMaxSum = Math.max(noDeleteMaxSum + arr[i], arr[i]);

            /* Two options for oneDelete:
            Option 1: oneDeleteMaxSum + arr[i]. -> Hum pehle hi ek element delete kar chuke hain, 
                      toh arr[i] ko delete nahi kar skte hai, ise len hi padega.
            Option 2: prevNoDeleteMaxSum  -> (Mtlb arr[i] ko delete kr do)
            Ye sabse important logic hai. prevNoDelete ka matlab hai: 
            "Index i-1 tak ka max sum jisme abhi tak kuch bhi delete nahi hua ho."
            
            Ab socho, agar hum current element arr[i] ko delete kar dein, toh hamara 
            "one-deletion state" wala sum kya banega?
            Wo banega: (Max sum up to i-1 with no deletes) + (Delete current element arr[i])
            
            Math ki language mein: prevNoDelete + 0 (kyuki arr[i] ko skip/delete kar diya).
            Isliye, prevNoDelete hi hamara woh sum hai jo humein current element arr[i] ko delete karne
            ke baad milega. */
            oneDeleteMaxSum = Math.max(oneDeleteMaxSum + arr[i], prevNoDeleteMaxSum);

            // Update the overall maximum found so far
            result = Math.max(result, Math.max(noDeleteMaxSum, oneDeleteMaxSum));
        }
        return result;
    }
}