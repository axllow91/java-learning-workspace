package exceptii;

public class APIFormaChangeException extends Exception {
    private String response;
    private String elementName;
    private String partner;

    public APIFormaChangeException(String response, String elementName, String partner, Throwable cause) {
        super("Response: " + response + ", Element: " + elementName + ", Partner: "  + cause);
        this.response = response;
        this.elementName = elementName;
        this.partner = partner;
    }

//    public APIFormaChangeException(String message) {
//        super(message);
//    }


    public String getResponse() {
        return response;
    }

    public String getElementName() {
        return elementName;
    }

    public String getPartner() {
        return partner;
    }
}
