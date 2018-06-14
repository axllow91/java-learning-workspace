package exceptii;

public class APIParser {

    public static int parseSendResponseCode(String response, String element, String partner) throws APIFormaChangeException {
        int responseCode = -1;
        try {
            String startTag = "<code>";
            String endTag = "</code>";
            if(response.contains(startTag)) {
                int beginIndex = response.indexOf(startTag) + startTag.length();
                int endIndex = response.indexOf(endTag);
                System.out.println("code: " + response.substring(beginIndex, endIndex));
                responseCode = Integer.parseInt(response.substring(beginIndex, endIndex));
            }
        } catch (NumberFormatException e) {
            throw new APIFormaChangeException(response, element, "code", e);
        }
        return responseCode;
    }
}
