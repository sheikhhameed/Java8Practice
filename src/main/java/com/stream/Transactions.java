package com.stream;

public class Transactions {

        private final Traders trader;
        private final int year;
        private final int value;
        public Transactions(Traders trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Traders getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }
        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }

