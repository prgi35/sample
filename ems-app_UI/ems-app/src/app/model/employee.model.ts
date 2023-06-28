export class employee {
    employeeId: number;
    yashEmpId:number;
    employeeName: string;
    grade: string;
    designation: string;
    email: string;
    dateOfJoining: string;
    baseLocation: string;
    currentLocation: string;
    primarySkills: string;
    secondarySkills: string;
    exprience: string;
    mobileNo: number;
    irm: string;

    constructor(employeeId?: number, employeeName?: string, grade?: string, designation?: string, email?: string, dateOfJoining?: string, baseLocation?: string, currentLocation?: string, primarySkills?: string, secondarySkills?: string, exprience?: string, mobileNo?: number, irm?: string, yashEmpId?: number) {
        this.employeeId = employeeId || 0;
        this.employeeName = employeeName || '';
        this.grade = grade || '';
        this.designation = designation || '';
        this.email = email || '';
        this.dateOfJoining = dateOfJoining || '';
        this.baseLocation = baseLocation || '';
        this.currentLocation = currentLocation || '';
        this.primarySkills = primarySkills || '';
        this.secondarySkills = secondarySkills || '';
        this.exprience = exprience || '';
        this.mobileNo = mobileNo || 0;
        this.irm = irm || '';
        this.yashEmpId = yashEmpId;

    }
}