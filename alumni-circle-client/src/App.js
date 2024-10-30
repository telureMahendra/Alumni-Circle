import logo from './logo.svg';
import './App.css';
import AlumniForm from './alumni/AlumniForm';
import AlumniList from './alumni/AlumniList';
import PostJobForm from './job/PostJobForm';
import JobList from './job/JobList';

function App() {
  return (
    <div className="App">
     <h1>Alumni Circle</h1>
     <AlumniForm />
     <AlumniList />
     <PostJobForm/>
     <JobList/>
    </div>
  );
}

export default App;
