import learning.streams.StreamsDemo;

import java.util.ArrayList;
import java.util.List;

// java 17
public class Main {
    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
        demo.practiceStreams();
    }
}

class Product {
    int id;

    Product(int id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Product other = (Product) obj;
//        return id == other.id;
//    }
}
