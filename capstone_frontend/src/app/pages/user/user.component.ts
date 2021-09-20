import { Component, OnInit } from "@angular/core";
import { CustodianService } from "src/app/service/custodian.service";

@Component({
  selector: "app-user",
  templateUrl: "user.component.html"
})
export class UserComponent implements OnInit {
  constructor(private custodianService:CustodianService) {}

  ngOnInit() {}
  user=localStorage.getItem('id')
  custodian=localStorage.getItem('cust_name')
}
