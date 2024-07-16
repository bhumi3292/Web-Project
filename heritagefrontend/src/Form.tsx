// import {useForm}from "react-hook-form";
// import {Simulate} from "react-dom/test-utils";
// import error = Simulate.error;
//
//
//
//
// function Form(){
//      const {register,handleSubmit,
//          formState}=useForm({
//          initialValues:{name:"",c_No:"",Email:""},
//      });
//      const{errors}=formState;
//      console.log(errors);
//
//      const onSubmit=(date:any)=>{
//          console.log(date);
//
//
//      }
//      return(
//          <>
//              <form onSubmit={handleSubmit(onSubmit)}>
//                  <div>
//                      <label htmlFor="name">Name</label>
//                      <input
//                          type="text"
//                          id="name"
//                          {...register("name",{required:"Name is required"})}
//                      />
//                      {error.name && <span className="text-danger">{error.name.message}</span>}
//                  </div>
//                  <div>
//
//                      <label htmlFor="c_No">c_No</label>
//                      <input
//                          type={"text"
//                              id="'"
//                          />
//
//                  </div>
//                  <label htmlFor="E-mail">E-mail</label>
//                      <input type="text"{...register("name",{required:true})}/>
//                      <span className="text-danger">{errors?.name?.message}</span>
//                  </div>
//                  <div>
//                      <input type="Submit"/>
//                  </div>
//              </form>
//          </>
//
//
//
//      )
//
//
//  }
//
//  export default Form;
//
