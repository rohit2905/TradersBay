import { Component, OnInit } from "@angular/core";

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  {
    path: "/home",
    title: "Home",
    icon: "icon-istanbul",
    class: "" },
    {
    path: "/order",
    title: "Order",
    icon: "icon-atom",
    class: ""
  },
  {
    path: "/dashboard",
    title: "Dashboard",
    icon: "icon-chart-pie-36",
    class: ""
  },

  {
    path: "/user",
    title: "User Profile",
    icon: "icon-single-02",
    class: ""
  },
  
  {
    path: "/typography",
    title: "About us",
    icon: "icon-bulb-63",
    class: ""
  }
];

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.css"]
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() {}

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }
}
