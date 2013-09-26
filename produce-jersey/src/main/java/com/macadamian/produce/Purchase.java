package com.macadamian.produce;

import javax.xml.bind.annotation.*;
import org.codehaus.jackson.annotate.*;

@XmlAccessorType(XmlAccessType.FIELD)
class Purchase {
    public int id;
    public int fruit_id;
    public int quantity;
};

    
