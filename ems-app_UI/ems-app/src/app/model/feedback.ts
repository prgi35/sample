export class Feedback {
    feedback_id!: number; 
    project_name!: String ;
    client_name!:String;
    project_manager!:String;
    reason_for_release!:String; 
    technical_knowledge_rating!:number;
    work_quality_rating!:number;
    employee_id!:number;
    communication_rating!:number;
    overall_rating!:number;
    team_playing_rating!:number;
    remarks!: String ;
    
}

export interface Root {
    feedback_id: number;
    project_name: string;
    client_name: string;
    project_manager: string;
    reason_for_release: string;
    technical_knowledge_rating: number;
    work_quality_rating: number;
    employee_id:number;
    communication_rating: number;
    team_playing_rating: number;
    overall_rating: number;
    remarks: string;
  }