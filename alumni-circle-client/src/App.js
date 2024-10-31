import logo from './logo.svg';
import './App.css';
import AlumniForm from './alumni/AlumniForm';
import AlumniList from './alumni/AlumniList';
import PostJobForm from './job/PostJobForm';
import JobList from './job/JobList';
import ImagePath from './components/ImagePath';


function App() {
  return (
    <div className="App">
     <h1>Alumni Circle</h1>
     {/* <AlumniForm />
     <AlumniList />
     <PostJobForm/>
     <JobList/> */}
     <ImagePath />
    </div>
  );
}

export default App;
