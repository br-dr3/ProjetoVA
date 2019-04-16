package projetova.model;

import java.util.HashMap;
import java.util.Map.Entry;

public class Rule {
    public int number;
    public int k;

    public Rule(int number) {
        this(number, 3);
    }

    public Rule(int number, int k) {
        this.number = number;
        this.k = k;
    }

    public int getNumber() {
        return this.number;
    }

    public String getBinaryNumber() {
        return this.getBinaryNumber(this.number, (int) Math.pow(2, k));
    }

    public String getBinaryNumber(int num, int size) {
        String s = Integer.toBinaryString(num);

        while (s.length() < size) {
            s = "0" + s;
        }

        return s;
    }

    public char charAt(int i) {
        return this.getBinaryNumber().charAt(i);
    }

    public HashMap<String, Boolean> getPattern() {
        HashMap<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < this.getBinaryNumber().length(); i++)
            map.put(this.getBinaryNumber(i,
                                         this.getK()),
                                         this.charAt(this.getBinaryNumber().length()-1-i) == '1');

        return map;
    }

    public int getK() {
        return this.k;
    }

    @Override
    public String toString() {
        HashMap<String, Boolean> map = this.getPattern();
        StringBuilder s = new StringBuilder();

        s.append("{");
        for (Entry<String, Boolean> m : map.entrySet())
            s.append("    '" + m.getKey()
                             + "' -> " + m.getValue().toString()
                             + "\n");
        s.append("}");

        return s.toString();
    }
}
