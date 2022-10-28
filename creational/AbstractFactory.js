class WoodenChair
{
    getRawMaterials() {
        console.log("wooden chair materials arrived!!");
    }   
}

class PlasticChair 
{
    getRawMaterials() {
        console.log("plastic chair materials arrived!!");
    }   
}

class WoodenMaterialExpert {
     assemble() {
        console.log("wood expert has completed the assembling!!");
    }
}

class PlasticMaterialExpert {
     assemble() {
        console.log("plastic expert has completed the assembling!!");
    }
}


/**
 * Specific factory is responsible for creating
 * objects of specfic variety
 */
class WoodenChairFactory
{
    getChair()
    {
        return new WoodenChair();
    }

    getMaterialExpert()
    {
        return new WoodenMaterialExpert();
    }
}

class PlasticChairFactory
{
    getChair()
    {
        return new PlasticChair();
    }

    getMaterialExpert()
    {
        return new PlasticMaterialExpert();
    }
}


// start of client code 


class Application {
    constructor(factory) {
        this._chair = factory.getChair();
        this._materialExpert = factory.getMaterialExpert();
    }

     assembleChairWithMaterialExpert() {
        this._chair.getRawMaterials();
        this._materialExpert.assemble();
    }
}

let plasticChair = new Application(new PlasticChairFactory());
plasticChair.assembleChairWithMaterialExpert();

let woodenChair = new Application(new WoodenChairFactory());
woodenChair.assembleChairWithMaterialExpert();
// end of client code 
