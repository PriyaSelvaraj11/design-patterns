class PlasticChair {
    constructor(numberOfLegs, height)
    {
        this._numberOfLegs = numberOfLegs;
        this._height = height;
    }

    getNumberOfLegs()
    {
        return this._numberOfLegs;
    }

    getHeight()
    {
        return this._height;
    }
}


/** Simple factory which creates an instance 
without exposing any instantiation logic to the caller **/
const ChairFactory = {
    makeChair: function(numberOfLegs, height) {
        return new PlasticChair(numberOfLegs, height);
    }
}


/**
 * start of client code
 */
const chair = ChairFactory.makeChair(3, 4.5);
console.log(chair.getHeight());

/**
 * end of client code
 */

// OUTPUT
// 4.5