package com.macadamian.produce;

import javax.xml.bind.annotation.*;
import org.codehaus.jackson.annotate.*;

@XmlAccessorType(XmlAccessType.FIELD)
class Fruit {
    public int id;
    public String type;
    public int quantity;
    public double price;
};
    
