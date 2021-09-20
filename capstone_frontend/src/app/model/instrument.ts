export class Instrument{
    constructor(public instrument_id:string='',
                public instrument_name:string='',  
                public face_value:number=0,
                public price:number=0,
                public expiry_date:Date=new Date(),
                public min_quantity:number=0
                ){}
             
}