
export class User{

  public id: number;
  public name: string;
  public email : string;
  public password: string;
  public role : string;
  public confirmPassword : string;
  public authStatus : string;
  public authErrorMsg : string;


  constructor(id?: number,name?: string, email?: string,  password?: string,role?: string, confirmPassword?: string, authStatus?:string, authErrorMsg?:string){
        this.id = id || 0;
        this.name = name || '';
        this.email = email || '';
        this.password = password || '';
        this.role = role || '';
        this.confirmPassword = confirmPassword || '';
        this.authStatus = authStatus || '';
        this.authErrorMsg = authErrorMsg || '';
  }

}
