import { Component, OnInit } from "@angular/core";
import { NavigationEnd, Router } from "@angular/router";

import { AuthService } from "src/app/auth.service";
import { Client } from "src/app/model/client";

import { Order } from "src/app/model/order";
import { ClientService } from "src/app/service/client.service";

import { InstrumentService } from "src/app/service/instrument.service";
import { OrderService } from "src/app/service/order.service";

declare const google: any;

interface Marker {
lat: number;
lng: number;
label?: string;
draggable?: boolean;
}

@Component({
  selector: "app-map",
  templateUrl: "map.component.html"
})
export class MapComponent implements OnInit {

  records:Client[];
  buyRecords:Order[];
  custodianid:any;

  constructor(private clientService:ClientService, private orderService:OrderService, private instrumentService:InstrumentService) {
    this.custodianid=localStorage.getItem('id')
    
    this.clientService.getClientByCID(this.custodianid).subscribe(res=>{
    this.records=res;})
   this.orderService.getAllBuyOrders().subscribe(res=>{
     this.buyRecords=res;
   })

  
    
  }
  
  


  ngOnInit() {
   
   
  }
  

  
}
