package p04Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> phoneNumbers;
    private List<String> sites;

    public Smartphone(List<String> phoneNumbers, List<String> sites) {
        this.phoneNumbers = phoneNumbers;
        this.sites = sites;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.phoneNumbers) {
            if (!checkPhoneNumber(number)) {
                sb.append("Invalid number!");
            } else {
                sb.append("Calling... " + number);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String site: this.sites) {
            if (!checkSite(site)){
                sb.append("Invalid URL!");
            } else {
                sb.append("Browsing: " + site + "!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private boolean checkSite(String site) {
        boolean hasDigit = true;
        for (Character ch : site.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = false;
                break;
            }
        }
        return hasDigit;
    }

    private boolean checkPhoneNumber(String number) {
        boolean hasOnlyDigits = true;
        for (Character ch : number.toCharArray()) {
            if (!Character.isDigit(ch)) {
                hasOnlyDigits = false;
                break;
            }
        }
        return hasOnlyDigits;
    }
}
