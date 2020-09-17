class Codelab extends React.Component {
  render()  {
    return (
      <div>
        <h1>{this.props.msg} {this.props.name} !</h1>
        <h1>He is {this.props.age} years old</h1>
      <div>{this.props.children}</div>
      </div>
    );
  }
}

Codelab.defaultProps = {
  age: 40
}

class Counter extends React.Component {
  
}

class App extends React.Component {
  render()  {
    return (
      <Codelab msg="Hi" name="Dgkim">hahaha</Codelab>
    );
  }
}

ReactDOM.render(<App/>,document.getElementById("rootdiv"));