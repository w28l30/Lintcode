public class Solution {
	/**
	 * @param s
	 *            the IP string
	 * @return All possible valid IP addresses
	 */
	public ArrayList<String> restoreIpAddresses(String s) {
		// Write your code here
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return res;
		}
		restoreIpAddressesHelper(s, "", 1, res);
		return res;
	}

	public void restoreIpAddressesHelper(String curString, String pre, int cnt, ArrayList<String> res) {
		if (!check(curString, cnt)) {
			return;
		}
		int strLen = curString.length();
		int length = (strLen >= 3 ? 3 : strLen);
		for (int i = 1; i <= length; i++) {
			StringBuilder sb = new StringBuilder(pre);
			String sub = curString.substring(0, i);
			String after = curString.substring(i);
			if (Integer.parseInt(sub) > 255) {
				return;
			}
			if (sub.charAt(0) == '0' && sub.length() > 1) {
				return;
			}
			if (cnt == 1) {
				sb.append(sub);
			} else {
				sb.append("." + sub);
			}

			if (cnt == 4 && after.length() == 0) {
				res.add(sb.toString());
				continue;
			}
			restoreIpAddressesHelper(after, sb.toString(), cnt + 1, res);
		}
	}

	public boolean check(String curString, int cnt) {
		if (curString == null || curString.length() == 0) {
			return false;
		}
		int length = curString.length();
		if (cnt == 1 && (length > 12 || length < 4)) {
			return false;
		} else if (cnt == 2 && (length > 9 || length < 3)) {
			return false;
		} else if (cnt == 3 && (length > 6 || length < 2)) {
			return false;
		} else if (cnt == 4 && (length > 3 || length == 0)) {
			return false;
		} else {
			return true;
		}
	}
}