package peter.sphereoj.solutions.in_progress;

/**
 * Created by Piotr Kulma on 11.04.15.
 */
public final class QuickInteger implements Comparable<QuickInteger> {
    public final static String ZERO_STRING = "0";

    //private final static QuickInteger QI_ZERO = new QuickInteger(ZERO_STRING);

    private final String STRING_EMPTY = "";
    private final String value;

    public QuickInteger(String value) {
        this.value = value;
    }

    public QuickInteger quickMul(QuickInteger qi) {
        int n = Math.max(this.toString().length(), qi.toString().length());
        int m = n / 2;

        QuickInteger h1 = new QuickInteger(value.toString().substring(0, m));
        QuickInteger l1 = new QuickInteger(value.toString().substring(m, value.toString().length()));

        QuickInteger h2 = new QuickInteger(qi.toString().substring(0, m));
        QuickInteger l2 = new QuickInteger(qi.toString().substring(m, qi.toString().length()));

        return mul(qi);
    }

    public QuickInteger mul(QuickInteger qi) {
        StringBuffer mulBuilder = new StringBuffer(STRING_EMPTY);
        String arg1, arg2;

        if(qi.toString().length() > value.length()) {
            arg1 = qi.toString();
            arg2 = value;
        } else {
            arg1 = value;
            arg2 = qi.toString();
        }

        int zeros = 0;
        int memory = 0;
        int num1, num2, partialProduct;
        QuickInteger sum = new QuickInteger(ZERO_STRING);

        for(int i=arg2.length()-1; i>=0; i--) {
            num1 = arg2.charAt(i) - 48;

            if(num1>0) {
                if(zeros > 0) {
                    mulBuilder.append(getZeros(zeros));
                }

                for (int j = arg1.length() - 1; j >= 0; j--) {
                    num2 = arg1.charAt(j) - 48;

                    partialProduct = (num1 * num2) + memory;

                    if (partialProduct >= 10) {
                        memory = partialProduct / 10;
                        partialProduct = partialProduct % 10;
                    } else {
                        memory = 0;
                    }

                    mulBuilder.append(partialProduct);
                }
                if(memory > 0) {
                    mulBuilder.append(memory);
                    memory = 0;
                }
                sum = sum.add(new QuickInteger(mulBuilder.reverse().toString()));
                mulBuilder = new StringBuffer(STRING_EMPTY);
            }
            zeros++;
        }

        return new QuickInteger(sum.toString());
    }

    private String getZeros(int count) {
        StringBuffer buffer = new StringBuffer(STRING_EMPTY);
        for (int i = 0; i < count; i++) {
            buffer.append(ZERO_STRING);
        }

        return buffer.toString();
    }

    public QuickInteger add(QuickInteger qi) {
        StringBuffer mulBuilder = new StringBuffer(STRING_EMPTY);
        String arg1, arg2;

        if(qi.toString().length() > value.length()) {
            arg1 = qi.toString();
            arg2 = value;
        } else {
            arg1 = value;
            arg2 = qi.toString();
        }

        int memory = 0;
        int num1, num2, partialSum;
        int j = arg2.length() - 1;

        for(int i=arg1.length()-1; i>=0; i--) {
            num1 = arg1.charAt(i) - 48;

            if(j >= 0) {
                num2 = arg2.charAt(j) - 48;
            } else {
                num2 = 0;
            }

            partialSum = num1 + num2 + memory;

            if(partialSum >= 10) {
                memory = 1;
                partialSum = partialSum - 10;
            } else {
                memory = 0;
            }

            j--;
            mulBuilder.append(partialSum);

            if(j < 0 && memory == 0) {
                StringBuffer temp = new StringBuffer(arg1.substring(0, i));
                mulBuilder.append(temp.reverse());
                break;
            }
        }
        if(memory > 0) {
            mulBuilder.append(memory);
        }

        return new QuickInteger(mulBuilder.reverse().toString());
    }

    public QuickInteger sub(QuickInteger qi) {
        StringBuffer mulBuilder = new StringBuffer(STRING_EMPTY);
        String arg1, arg2;

        if(qi.toString().length() > value.length()) {
            arg1 = qi.toString();
            arg2 = value;
        } else {
            arg1 = value;
            arg2 = qi.toString();
        }

        int memory = 0;
        int num1, num2, partialSub;
        int j = arg2.length() - 1;

        for(int i=arg1.length()-1; i>=0; i--) {
            num1 = arg1.charAt(i) - 48;

            if(j >= 0) {
                num2 = arg2.charAt(j) - 48;
            } else {
                num2 = 0;
            }

            num1 = num1 - memory;
            if(num1 < num2) {
                num1 = (num1 + 10);
                memory = 1;
            } else {
                memory = 0;
            }

            partialSub = num1 - num2;

            j--;
            mulBuilder.append(partialSub);

            if(j < 0 && memory == 0) {
                StringBuffer temp = new StringBuffer(arg1.substring(0, i));
                mulBuilder.append(temp.reverse());
                break;
            }
        }
        if(memory > 0) {
            mulBuilder.append(memory);
        }

        return new QuickInteger(mulBuilder.reverse().toString());
    }

    @Override
    public String toString() {
        return this.value;
    }

    public int compareTo(QuickInteger o) {
        if(value.length() == o.toString().length()) {
            if(!value.equals(o.toString())) {
                int c1, c2;
                for(int i=0; i<value.length(); i++) {
                    c1 = value.charAt(i);
                    c2 = o.toString().charAt(i);

                    if(c1 > c2) {
                        return 1;
                    } else if(c1 < c2) {
                        return -1;
                    }
                }
                return 0;
            } else {
                return 0;
            }
        } else {
            if(value.length() > o.toString().length()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
