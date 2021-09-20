import { Routes } from "@angular/router";

import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { IconsComponent } from "../../pages/icons/icons.component";
import { MapComponent } from "../../pages/map/map.component";
import { UserComponent } from "../../pages/user/user.component";
import { TypographyComponent } from "../../pages/typography/typography.component";
import { LoginComponent } from "src/app/login/login.component";

export const AdminLayoutRoutes: Routes = [
  {path:"login", component:LoginComponent},
  { path: "dashboard", component: DashboardComponent },
  { path: "order", component: IconsComponent },
  { path: "home", component: MapComponent },
  { path: "user", component: UserComponent },
  { path: "typography", component: TypographyComponent },
  
 
];
