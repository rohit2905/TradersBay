export class Order{
    title:string="Select Client ID";
    constructor(public instrument_id:string='',
                public client_id:string='',
                public quantity:number=0,
                public price:number=0
                ){}
}