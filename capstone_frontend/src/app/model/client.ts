export class Client{
    constructor(public client_id:string='',
                public client_name:string='',
                public cust_id:string='',
                public transaction_limit:number=0,
                public amount:number=0
                ){}
}